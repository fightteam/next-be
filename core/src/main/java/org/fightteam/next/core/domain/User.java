package org.fightteam.next.core.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

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
