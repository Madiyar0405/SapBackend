package com.project.sapbackend.entity;

// IncidentRequestCause.java
import javax.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "IncidentRequestCauses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class IncidentRequestCause {
    @EmbeddedId
    private IncidentRequestCauseId id;

    @ManyToOne
    @MapsId("requestId")
    @JoinColumn(name = "request_id")
    private IncidentRequest incidentRequest;

    @ManyToOne
    @MapsId("causeId")
    @JoinColumn(name = "cause_id")
    private IncidentCause incidentCause;

}

@Embeddable
class IncidentRequestCauseId implements Serializable {
    private Long requestId;
    private Long causeId;

    // Override equals() and hashCode() for composite key comparison
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IncidentRequestCauseId that = (IncidentRequestCauseId) o;
        return Objects.equals(requestId, that.requestId) &&
                Objects.equals(causeId, that.causeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requestId, causeId);
    }
}

