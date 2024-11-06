public class DataObject {

    private double data1;
    private double data2;
    private String data3;

    public void manipulateData() {
        data1 += 1;
        data2 = data1 * data1;
        data3 = "Values: " + data1 + ", " + data2;
        System.out.println(data3);
    }
}
