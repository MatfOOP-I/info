package rs.math.oop1.z140500.ispitivanjeZabeleski.z02.geometrija;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@interface PreambulaKlase {
    String author();

    String date();

    int currentRevision() default 1;

    String lastModified() default "N/A";

    String lastModifiedBy() default "N/A";

    // Note use of array
    String[] reviewers();
}
