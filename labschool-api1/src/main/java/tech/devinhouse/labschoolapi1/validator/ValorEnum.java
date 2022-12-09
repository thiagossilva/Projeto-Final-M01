package tech.devinhouse.labschoolapi1.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = ValidadorEnum.class)
public @interface ValorEnum {

    Class<? extends Enum<?>> enumClass();
    String message() default "Deve ser um dos valores da enum {enumClass}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
