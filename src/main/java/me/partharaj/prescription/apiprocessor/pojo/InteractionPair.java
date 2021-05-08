
package me.partharaj.prescription.apiprocessor.pojo;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class InteractionPair {

    @Expose
    private String description;
    @Expose
    private List<InteractionConcept> interactionConcept;
    @Expose
    private String severity;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<InteractionConcept> getInteractionConcept() {
        return interactionConcept;
    }

    public void setInteractionConcept(List<InteractionConcept> interactionConcept) {
        this.interactionConcept = interactionConcept;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

}
