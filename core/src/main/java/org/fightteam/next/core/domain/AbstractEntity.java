package org.fightteam.next.core.domain;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 实体抽象结构
 *
 * @author faith
 * @since 0.0.1
 */
@Getter
@Setter
@MappedSuperclass
public abstract class AbstractEntity<T> implements Serializable {
    @Id
    @GeneratedValue
    private T id;
    @Temporal(TemporalType.TIMESTAMP)
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime createDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime updateDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractEntity)) return false;

        AbstractEntity abstractEntity = (AbstractEntity) o;

        return new EqualsBuilder().append(getId(), abstractEntity.getId()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(getId()).
                toHashCode();
    }

}
