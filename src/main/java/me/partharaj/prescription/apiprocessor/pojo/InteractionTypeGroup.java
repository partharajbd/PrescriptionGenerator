
package me.partharaj.prescription.apiprocessor.pojo;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class InteractionTypeGroup {

    @Expose
    private List<InteractionType> interactionType;
    @Expose
    private String sourceDisclaimer;
    @Expose
    private String sourceName;

    public List<InteractionType> getInteractionType() {
        return interactionType;
    }

    public void setInteractionType(List<InteractionType> interactionType) {
        this.interactionType = interactionType;
    }

    public String getSourceDisclaimer() {
        return sourceDisclaimer;
    }

    public void setSourceDisclaimer(String sourceDisclaimer) {
        this.sourceDisclaimer = sourceDisclaimer;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

}
