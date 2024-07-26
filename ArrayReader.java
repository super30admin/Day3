public interface ArrayReader {
    public default int get(int index) {
        return Integer.MAX_VALUE;
    }
}
