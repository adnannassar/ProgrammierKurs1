package MiedenVerwaltungFX.Datenhaltung;

import java.io.IOException;

public class PersistenzException extends IOException {
    public PersistenzException() {
        super();
    }

    public PersistenzException(String message) {
        super(message);
    }
}
