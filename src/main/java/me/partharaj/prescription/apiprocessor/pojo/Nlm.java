
package me.partharaj.prescription.apiprocessor.pojo;

import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Nlm {

    @Expose
    private List<InteractionTypeGroup> interactionTypeGroup;
    @Expose
    private String nlmDisclaimer;
    @Expose
    private UserInput userInput;

    public List<InteractionTypeGroup> getInteractionTypeGroup() {
        return interactionTypeGroup;
    }

    public void setInteractionTypeGroup(List<InteractionTypeGroup> interactionTypeGroup) {
        this.interactionTypeGroup = interactionTypeGroup;
    }

    public String getNlmDisclaimer() {
        return nlmDisclaimer;
    }

    public void setNlmDisclaimer(String nlmDisclaimer) {
        this.nlmDisclaimer = nlmDisclaimer;
    }

    public UserInput getUserInput() {
        return userInput;
    }

    public void setUserInput(UserInput userInput) {
        this.userInput = userInput;
    }

}
