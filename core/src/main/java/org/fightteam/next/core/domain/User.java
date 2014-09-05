package org.fightteam.next.core.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;

/**
 * 简单用户类
 *
 * @author faith
 * @since 0.0.1
 */
@Getter
@Setter
@Entity
@Table(name = "user")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class User extends AbstractUser<Long> {

}
