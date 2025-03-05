import java.util.Date;

import lombok.*;

public record ProductEnum(@NonNull String nameProduct, @NonNull String supplier, int amount,
    @NonNull Date dateExpiration) {
}
