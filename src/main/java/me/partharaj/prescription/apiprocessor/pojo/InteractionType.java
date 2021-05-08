
package me.partharaj.prescription.apiprocessor.pojo;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class InteractionType {

    @Expose
    private String comment;
    @Expose
    private List<InteractionPair> interactionPair;
    @Expose
    private MinConceptItem minConceptItem;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<InteractionPair> getInteractionPair() {
        return interactionPair;
    }

    public void setInteractionPair(List<InteractionPair> interactionPair) {
        this.interactionPair = interactionPair;
    }

    public MinConceptItem getMinConceptItem() {
        return minConceptItem;
    }

    public void setMinConceptItem(MinConceptItem minConceptItem) {
        this.minConceptItem = minConceptItem;
    }

}
