package valueObjects;


import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class Jmbg implements ValueObject {
    private final String jmbg;

    public Jmbg(@NotNull String jmbg) {
        this.jmbg = validate(jmbg);
    }

    @Override
    public @NotNull String toString() {
        return jmbg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jmbg that = (Jmbg) o;
        return jmbg.equals(that.jmbg);
    }

    @Override
    public int hashCode() {
        return jmbg.hashCode();
    }

    public static @NotNull String validate(@NotNull String jmbg) {
        if (!isValid(jmbg)) {
            throw new IllegalArgumentException("Invalid jmbg: " + jmbg);
        }
        return Objects.requireNonNull(jmbg, "Jmbg cannot be null");
    }

    public static boolean isValid(@NotNull String jmbg) {
        return jmbg.length() == 13;
    }
}
