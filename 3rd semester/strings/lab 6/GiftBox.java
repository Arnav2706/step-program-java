class Box {
    public void pack() {
        System.out.println("Box packed");
    }

    public void unpack() {
        System.out.println("Box unpacked");
    }
}

public class GiftBox extends Box {
    @Override
    public void pack() {
        super.pack();
        System.out.println("Gift wrapping added");
    }

    @Override
    public void unpack() {
        super.unpack();
        System.out.println("Unwrapping gift paper");
    }

    public static void main(String[] args) {
        GiftBox gb = new GiftBox();
        gb.pack();
        gb.unpack();
    }
}
