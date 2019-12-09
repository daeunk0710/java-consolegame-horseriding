/*
콘솔창에 출력하는 화면 모양에 대한 클래스
static 메소드 사용
 */

public class display {
    static int width = 100;

    // logo100: 너비 100인 Horseridig 로고 출력
    static void logo100() {
        System.out.print(
                "\n          288808  08088                                                                             \n" +
                        "          888887 080808                                                                             \n" +
                        "         888086 780808                                                                              \n" +
                        "        708888  808087                                                                              \n" +
                        "        080884 108080                                         777      777  777                     \n" +
                        "       7808080808080                                         0807     8882 8887                     \n" +
                        "       8088808880808  780888  780678 788080   180801  0881077091 78882080 7067 08894887 78887888    \n" +
                        "      908080 188888  08074805 808087008 888  084 080 780808 808  080 080  808 7080 080  808 8081    \n" +
                        "      08888  908081 1801 808 70807 7088     88011805 80847 5081 080  806 8887 080  880 808  088     \n" +
                        "     880804 708080  808 1087 888    18888  58047171 7886   880 7881 808  080 7881 888 7881 080      \n" +
                        "    780888  880807 888  080 1805  777 1800 808 788  080   0807 808 1087 088  808 1881 088 7808      \n" +
                        "    808087 080808  080 080  808   808 888 9082 088 8802  5808 88867880 1888 8087 888  6025888       \n" +
                        "   108880  80888   088087  8087   480881   888007  808   8087 08818807 808  088 5887 655 9887       \n" +
                        "                                                                                     080805        \n");
    }

    // horseImg100: 너비 100인 말타는 이미지 출력
    static void horseImg100() {
        System.out.println(
                "                                           7MBS.                                                    \n" +
                        "                                         2BBBBBBB:                                                  \n" +
                        "                                       :BBBBBBBBBB                                                  \n" +
                        "                                       :.BBBBBBB7                                                   \n" +
                        "                                          BBBBBB                                                    \n" +
                        "                                            8BBBBB7                                                 \n" +
                        "  iB2.      .....                         :BBBBBBBBB                                                \n" +
                        "    BBBBMBBBBBBBBBBBBXr.                   BBBBBBBBB                                                \n" +
                        "    XBBBBBBBBBBBBBBBBBBBBM2:              .BBBBBBBB0                                                \n" +
                        "   SBBBBBBBBBBBBBBBBBBBBBBBBB2.   .2ii70BBBBBBBBBBBZ                                                \n" +
                        "  .BBBBBBBBBBBBBBBBBBBBBBBBBBBB8. :BBBBBBBBBBBBBBBBB.                                               \n" +
                        "   BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB   .                                           \n" +
                        "  BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB7MBB                                           \n" +
                        " XBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBM                                           \n" +
                        " BBBBBBBBBM27.   XBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBr::r777777ri.                            \n" +
                        "BBBBBBBB7         BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBM2i                       \n" +
                        "iMBBBBBi           BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB0XXMBB02i.           \n" +
                        "  iXi              BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBZMBBBBBM7        \n" +
                        "                  :BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB2   :8BBBBBB      \n" +
                        "                  BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBi     7BBBB2     \n" +
                        "                  BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB       BBBBB0    \n" +
                        "                  BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB.      BBBBBBB    \n" +
                        "                   BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB.        BBBBBBi   \n" +
                        "                  :BBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBB           BBBBB    \n" +
                        "                 iBBBBBBBBBBBBBBB808MBBBBBBBBBBBBBBBBBBZX7r. iBBBBBBBBBBBBBBBBB           SBBBBBXr  \n" +
                        "             2BBBBBBBBBBBMX27ri:           2X:               0BBBBBBBBBBBBBBB0            BBBBBBBBB \n" +
                        "            BBBBBBBBBB7                                     .BBBBBB0  BBBBBBB             XBBBBBBBB \n" +
                        "            BBBBBBBB0                                       BBBBBB7    XBBBBBB             BBBBBBBB:\n" +
                        "             MBBBBB.                                       :BBBBBS      iBBBBBB.            BBBBBBBr\n" +
                        "             8BBBB0                                       :BBBBBB         BBBBBB2            2BBBBBB\n" +
                        "           7BBBBBBBB:::.                                 0BBBBBB7          BBBBBB2             iXBBB\n" +
                        "          BBBB0:7XBBBBBB                              7BBBBB87.             BBBBB.                  \n" +
                        "        iBBBB7     BBBB7                          :XBBBBB8i                 7BBBB                   \n" +
                        "       MBBBB         .                         iMBBBBBX:                    BBBB2                   \n" +
                        "   i2MBBBSi                                 .7BBBBB2.                       BBBBi                   \n" +
                        "  BBBBB2                                  iBBBB2                           2BBBB                    \n" +
                        "  :r722                                   2BBBB                           .BBBBB                    \n" +
                        "                                                                      :8BBBMXX2.                    "
        );
    }

    static void badEnd100(){
        System.out.println(
                "                                                                                                    \n" +
                        "          70808884     0808088   2888087  808088  80888889     18080888  0888  78887 1808088897     \n" +
                        "         8088888080   88080889   808080  8088807 98808880      80808880 78080  8880  88808088807    \n" +
                        "        88807 80889  78080808   5088888 2080888  08081777     20808777  88808 78887 18888 78808     \n" +
                        "       20808 78808   88825088   8808087 080808  48086         88087    188080 0808  88087 08086     \n" +
                        "       88887     7  8888 8806  4808480 8858080  88807        58088     0808847808  18888  8880      \n" +
                        "      48080        2088  8087  80811886811088  60808080      88888081 18080808080  80807 88809      \n" +
                        "      8088 280808  8807 8880  6880 08888 0880  88080807     48808880  8080888888  58808 70888       \n" +
                        "     60808 10888  8888  8808  0801 8080 7888  08080         08887    20807080888  0808  08085       \n" +
                        "     0888  58881 98880888087 9808 70807 8084  8080         98880     0807 80808  48880 78080        \n" +
                        "    68088  8080 78080608880  8884 8888 9080  80808  7      88881 7  5808  08088  8888  88801        \n" +
                        "    80888680807 80807 70888 8888  808  0806 708080808     888880807 8084 78080  88808080808         \n" +
                        "     808087808 80808  88881 0800 1087 0808  08080808     708080808 0080  10808  8808080807          "
        );
    }

    // line: width 길이의 = 모양 선
    public static void line() {
        for (int i = 0; i < width; i++) {
            System.out.print("=");
        }
        System.out.println();
    }

    public static void line(int width) {
        for (int i = 0; i < width; i++) {
            System.out.print("=");
        }
        System.out.println();
    }

    // title: width 길이 문장 안에 입력받은 텍스트 가운데 정렬
    public static void title(String text){
        for (int i = 0; i < (width-text.length()-1)/2; i++) {
            System.out.print(" ");
        }
        System.out.print(text);
        for (int i = 0; i < (width-text.length()-1)/2; i++) {
            System.out.print(" ");
        }
        System.out.println();
    }

    public static void title(String text, int width){
        for (int i = 0; i < (width-text.length()-1)/2; i++) {
            System.out.print(" ");
        }
        System.out.print(text);
        for (int i = 0; i < (width-text.length()-1)/2; i++) {
            System.out.print(" ");
        }
        System.out.println();
    }

    // boxUpper: width 길이의 ┏ ━━ ┓ 꺽쇄 박스 윗면
    public static void boxUpper(){
        System.out.print("┏");
        for (int i = 0; i < (width-2); i++) {
            System.out.print("━");
        }
        System.out.print("┓");
        System.out.println();
    }

    public static void boxUpper(int width){
        System.out.print("┏");
        for (int i = 0; i < (width-2); i++) {
            System.out.print("━");
        }
        System.out.print("┓");
        System.out.println();
    }

    // boxMid: width 길이의 ┃ ┃ 꺽쇄 박스 중앙
    public static void boxMid(){
        System.out.print("┃");
        for (int i = 0; i < (width-2); i++) {
            System.out.print(" ");
        }
        System.out.print("┃");
        System.out.println();
    }

    public static void boxMid(int width){
        System.out.print("┃");
        for (int i = 0; i < (width-2); i++) {
            System.out.print(" ");
        }
        System.out.print("┃");
        System.out.println();
    }

    // perforation: width 길이의 ┣ ┫ 꺽쇄 박스 중앙
    public static void perforation(){
        System.out.print("┣");
        for (int i = 0; i < (width-2); i++) {
            System.out.print(" ");
        }
        System.out.print("┫");
        System.out.println();
    }

    public static void perforation(int width){
        System.out.print("┣");
        for (int i = 0; i < (width-2); i++) {
            System.out.print(" ");
        }
        System.out.print("┫");
        System.out.println();
    }

    // perforation2: width 길이의 ┣━┫ 꺽쇄 박스 중앙
    public static void perforation2(){
        System.out.print("┣");
        for (int i = 0; i < (width-2)/2; i++) {
            System.out.print("━ ");
        }
        System.out.print("┫");
        System.out.println();
    }

    public static void perforation2(int width){
        System.out.print("┣");
        for (int i = 0; i < (width-2)/2; i++) {
            System.out.print("━ ");
        }
        System.out.print("┫");
        System.out.println();
    }

    // boxLower: width 길이의 ┗ ━━ ┛ 꺽쇄 박스 아랫면
    public static void boxLower(){
        System.out.print("┗");
        for (int i = 0; i < (width-2); i++) {
            System.out.print("━");
        }
        System.out.print("┛");
        System.out.println();
    }

    public static void boxLower(int width){
        System.out.print("┗");
        for (int i = 0; i < (width-2); i++) {
            System.out.print("━");
        }
        System.out.print("┛");
        System.out.println();
    }

    // n 칸 건너뛰기
    public static void blank(int n){
        for (int i = 0; i <n; i++) {
            System.out.print(" ");
        }
    }

    // n 줄 건너뛰기
    public static void blankLine(int n){
        for (int i = 0; i <n; i++) {
            System.out.print("\n");
        }
    }

    // selectionBox1: 0. 저장하기/ (숫자로 입력해주세요)
    public void selectionBox1(){
        System.out.println(
                "                                             0. 저장하기                                            \n"+
                        "                                         (숫자로 입력해주세요)                                        ");
    }

    // selectionBox2: 0. 홈 화면 가기/ (숫자로 입력해주세요)
    public void selectionBox2(){
        System.out.println(
                "                                           0. 홈 화면 가기                                            \n"+
                        "                                         (숫자로 입력해주세요)                                        ");
    }

    // riderStatView: box 하단에 기승자 레벨/체력/운동량 출력
    public static void riderStatView(){
        System.out.print("┣");
        for (int i = 0; i < (width-2); i++) {
            System.out.print("━");
        }
        System.out.print("┫\n");

        System.out.println("  레벨: "+rider.getRiderLevel()+" 체력: "+rider.getRiderEnergy()+"/"+rider.getLevelEnergy()+" 운동량: "+rider.getRiderKcalBurned()+"/"+rider.getLevelKcalBurned());
        boxLower();
    }

    public static void riderStatView(int width){
        System.out.print("┣");
        for (int i = 0; i < (width-2); i++) {
            System.out.print("━");
        }
        System.out.print("┫\n");

        System.out.println("  기승자명: "+rider.getRiderName()+" ┃  레벨: "+rider.getRiderLevel()+" 체력: "+rider.getRiderEnergy()+"/"+rider.getLevelEnergy()+" 운동량: "+rider.getRiderKcalBurned()+"/"+rider.getLevelKcalBurned());
        boxLower(width);
    }
}
