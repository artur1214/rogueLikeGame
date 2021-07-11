package it.sevenbits.trex;

public class Coords {

    private int x, y;

    public Coords(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(final Object other) {
        if (!(other instanceof Coords)) {
            return false;
        }

        Coords that = (Coords) other;

        // Custom equality check here.
        return this.x == that.getX()
                && this.y == that.getY();
    }

    @Override
    public int hashCode() {
        int hashCode = 1;

        hashCode = hashCode * 37 + new Integer(x).hashCode() - 11;
        hashCode = hashCode * 37 + new Integer(y).hashCode();

        return hashCode;
    }

    public int getX() {
        return x;
    }

    public void setX(final int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(final int y) {
        this.y = y;
    }
}
