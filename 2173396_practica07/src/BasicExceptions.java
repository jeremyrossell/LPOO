public class BasicExceptions {
    public int division(int a, int b) {
        return a / b;
    }

    public void age(int a) throws Exception {
        if (a < 0) {
            throw new Exception("Algo anda mal");
        }

    }
}
