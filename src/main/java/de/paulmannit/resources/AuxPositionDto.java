package de.paulmannit.resources;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@RegisterForReflection
public class AuxPositionDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    Double profitToday;
    Double profitMonth;
    String month;
}
