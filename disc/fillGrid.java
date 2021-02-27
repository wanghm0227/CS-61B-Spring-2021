class fillGrid {
  // 按顺序一格一格填充
  public static void fill(int[] LL, int[] UR, int S[][]) {
    int N = S.length;
    int kL, kR;
    kL = kR = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (i < j) {
          S[i][j] = UR[kR];
          kR += 1;
        } else if (i > j) {
          s[i][j] = LL[kL];
          kL += 1;
        }
      }
    }
  }

  // 先填左下角，再填右上角
  public static void fill2(int[] LL, int[] UR, int S[][]) {
    int N = S.length;
    int kL, kR;
    kL = kR = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < i; j++) {
        S[i][j] = LL[kL];
        kL += 1;
      }
      for (int j + 1; j < N; j++) {
        S[i][j] = UR[kR];
        kR += 1;
      }
    }
  }

  // 利用arraycopy方法，先填左下角，再填右上角
  public static void fill3(int[] LL, int[] UR, int S[][]) {
    int N = S.length;
    int kL, kR;
    kL = kR = 0;
    for (int i = 0; i < N; i++) {
      System.arraycopy(LL, kL, S[i], 0, i);
      kL += i;
      System.arraycopy(Up, kR, S[i], i + 1, N - i - 1);
      kR += i;
    }
  }
}