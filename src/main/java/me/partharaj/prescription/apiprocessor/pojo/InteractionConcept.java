
package me.partharaj.prescription.apiprocessor.pojo;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class InteractionConcept {

    @Expose
    private MinConceptItem minConceptItem;
    @Expose
    private SourceConceptItem sourceConceptItem;

    public MinConceptItem getMinConceptItem() {
        return minConceptItem;
    }

    public void setMinConceptItem(MinConceptItem minConceptItem) {
        this.minConceptItem = minConceptItem;
    }

    public SourceConceptItem getSourceConceptItem() {
        return sourceConceptItem;
    }

    public void setSourceConceptItem(SourceConceptItem sourceConceptItem) {
        this.sourceConceptItem = sourceConceptItem;
    }

}
