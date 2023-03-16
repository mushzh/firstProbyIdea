package tools;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;

/** M_UT格納用成果物作成クラス */
public class SourceCopyForMUT {

    /** 出力ベースディレクトリ */
    private static final String OUTPUT_BASE_DIRECTORY = "D:\\修正ファイル洗い出す";

    /** 修正前フォルダ */
    private static final String BEFORE_FIX_FOLDER = "01_修正前";

    /** 修正後フォルダ */
    private static final String AFTER_FIX_FOLDER = "02_修正後";

    /** 新規分フォルダ */
    private static final String NEW_FOLDER = "03_新規分";

    /** 円マーク */
    private static final String EN_MARK = "\\";

    /** 日時(yyyyMMddHHmmss) */
    private static final String DATE = getDate();

    /** 重複ファイルセット */
    private static Set<String> obTyuufukuSet_ = new LinkedHashSet<>();

    /** 修正後ファイルセット */
    private static Set<String> obAfterFixSet_ = new LinkedHashSet<>();

    /** 新規分ファイルセット */
    private static Set<String> obNewSet_ = new LinkedHashSet<>();

    /** 処理できないファイルセット */
    private static Set<String> obErrSet_ = new LinkedHashSet<>();

    /** 原本ファイルパス */
    private static String obBeforPath_ = null;

    /** 修正後・新規分ファイルパス */
    private static String obAfterPath_ = null;

    /**
     * M_UT格納用成果物作成
     *
     * @param args 入力パラメータ
     */
    public static void main(String[] args) {

        /**
         * D:\test\SouceList.txt C:\winnt\mail\kdswork4_org C:\winnt\mail\kdswork4
         */
        // 引数が不足の場合
        if (args == null || args.length < 3) {
            printErr("パラメータが不足です。");
        }

        // 入力ファイルパス
        Path oStInputFilePath = toPath(args[0]);
        // 原本ファイルパス
        obBeforPath_ = args[1];
        // 修正後・新規分ファイルパス
        obAfterPath_ = args[2];

        // 入力値チェック
        if (Files.notExists(oStInputFilePath)) {
            printErr("入力ファイルパスが存在しません。");
            return;
        } else if (Files.notExists(toPath(obBeforPath_))) {
            printErr("原本ファイルパスが存在しません。");
            return;
        } else if (Files.notExists(toPath(obAfterPath_))) {
            printErr("修正後・新規分ファイルパスが存在しません。");
            return;
        }

        try {
            // ファイル内容を読み込む
            List<String> oLiFileList = Files.readAllLines(oStInputFilePath, Charset.defaultCharset());

            // ファイル取得処理を行う
            Set<String> obSetForCheck = new HashSet<>();
            Iterator<String> obIterator = oLiFileList.iterator();
            while (obIterator.hasNext()) {

                // ファイルパスを取得
                String oStMiniFilePath = obIterator.next();
                if (oStMiniFilePath.trim().length() == 0) {
                    continue;
                }

                // 重複のファイルが存在する場合、重複ファイルセットに追加する
                // 処理をスキップする
                if (obSetForCheck.contains(oStMiniFilePath)) {
                    obTyuufukuSet_.add(oStMiniFilePath);
                    continue;
                }

                // ファイルパスを格納
                obSetForCheck.add(oStMiniFilePath);

                // 原本に存在しないファイルの場合、新規分ファイルセットに追加する
                Path obFilePath = getBeforFixPath(oStMiniFilePath);
                if (Files.notExists(obFilePath)) {
                    // 新規分ファイルセットへ格納
                    obNewSet_.add(oStMiniFilePath);

                    // 新規分ファイルの取得を行う
                    doCopy(getAfterFixPath(oStMiniFilePath), NEW_FOLDER, oStMiniFilePath);

                    // スキップ
                    continue;
                }

                // 修正後ファイルセットへ格納
                obAfterFixSet_.add(oStMiniFilePath);

                // 修正前のファイルを取得する
                doCopy(getBeforFixPath(oStMiniFilePath), BEFORE_FIX_FOLDER, oStMiniFilePath);

                // 修正後のファイルを取得する
                doCopy(getAfterFixPath(oStMiniFilePath), AFTER_FIX_FOLDER, oStMiniFilePath);
            }

            // 正常終了
            printInfo();

        } catch (IOException e) {
            // 異常終了
            printErr("エラーが発生しました。" + System.lineSeparator() + e.toString());
        }
    }

    /**
     * 修正後・新規分ファイルパス取得
     *
     * @param oStPath 文字列
     * @return 修正後・新規分ファイル
     */
    private static Path getAfterFixPath(String oStPath) {
        return toPath(obAfterPath_ + EN_MARK + oStPath);
    }

    /**
     * 原本ファイルパス取得
     *
     * @param oStPath 文字列
     * @return 原本ファイル
     */
    private static Path getBeforFixPath(String oStPath) {
        return toPath(obBeforPath_ + EN_MARK + oStPath);
    }

    /**
     * 文字列をPathに変換
     *
     * @param oStPath 文字列
     * @return パス
     */
    private static Path toPath(String oStPath) {
        return Paths.get(oStPath);
    }

    /**
     * サーバー日時取得
     *
     * @return サーバー日時(yyyyMMddHHmmss)
     */
    private static String getDate() {
        Date date = new Date();
        return new SimpleDateFormat("yyyyMMddHHmmss").format(date);
    }

    /**
     * エラー出力
     */
    private static void printErr(String oStMsg) {
        System.out.println("【実行結果】　：　NG");
        System.out.println("【メッセージ】：　" + oStMsg);
    }

    /**
     * 処理結果出力
     */
    private static void printInfo() {
        System.out.println("【実行結果】　　：　OK");
        System.out.println("【出力先】　　　：　" + OUTPUT_BASE_DIRECTORY + EN_MARK + DATE);
        if (obAfterFixSet_.size() > 0) {
            System.out.println("-----------------------------------下記のソースが修正分となります。-----------------------------------");
            obAfterFixSet_.stream().forEach(System.out::println);
            System.out.println("【件数：　　】" + obAfterFixSet_.size() + "　　件");
        }
        if (obNewSet_.size() > 0) {
            System.out.println("-----------------------------------下記のソースが新規分となります。-----------------------------------");
            obNewSet_.stream().forEach(i -> System.out.println(i));
            System.out.println("【件数：　　】" + obNewSet_.size() + "　　件");
        }
        if (obTyuufukuSet_.size() > 0) {
            System.out.println("-----------------------------------下記のソースが重複となります。※提出時注意-----------------------------------");
            for (String msg : obTyuufukuSet_) {
                System.out.println(msg);
            }
            System.out.println("【件数：　　】" + obTyuufukuSet_.size() + "　　件");
        }
        if (obErrSet_.size() > 0) {
            System.out.println("-----------------------------------下記のソースが存在しないため、確認してください。---------------------------------");
            for (String msg : obErrSet_) {
                System.out.println(msg);
            }
            System.out.println("【件数：　　】" + obErrSet_.size() + "　　件");
        }
        System.out.println("-----------------------------------------------------------------------------------------------------");
    }

    /**
     * コピー実行
     *
     * @param obPathFrom        コピー元パス
     * @param oStFolderTo       コピー先フォルダ
     * @param oStMiniFilePath   入力ファイルパス（情報出力用）
     * @return 修正・新規分ファイル
     */
    private static void doCopy(Path obPathFrom, String oStFolderTo, String oStMiniFilePath) throws IOException {

        // ファイル格納ディレクトリ
        String oStDir = OUTPUT_BASE_DIRECTORY + EN_MARK + DATE + EN_MARK + oStFolderTo;
        // コピー先ファイルパス
        Path obPathTo = toPath(oStDir + EN_MARK + obPathFrom.toFile().getName());

        // ファイル格納ディレクトリが存在しない場合
        if (Files.notExists(toPath(oStDir))) {
            // ディレクトリを作成する
            Files.createDirectories(toPath(oStDir));
        }

        // ファイルがコピー元に存在しない場合
        if (Files.notExists(obPathFrom)) {
            // 修正後ファイルセットに格納
            obErrSet_.add(oStMiniFilePath);

            // 修正後ファイルセットと処理できないファイルセットに
            // 該当するキーを削除する
            obNewSet_.remove(oStMiniFilePath);
            obAfterFixSet_.remove(oStMiniFilePath);

            // 処理終了
            return;
        }

        // ファイルコピーを行う
        Files.copy(obPathFrom, obPathTo);
    }
}
