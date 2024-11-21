class Main {
  public static void main(String[] args) {
   divideDoubleByZero();
   divideIntByZero();
  }
   
  public static void divideDoubleByZero() {
    double num = 6.0;
    System.out.println(num/0);
  }
  
  public static void divideIntByZero() {
    int num = 6;
    System.out.println(num/0);
  }
}