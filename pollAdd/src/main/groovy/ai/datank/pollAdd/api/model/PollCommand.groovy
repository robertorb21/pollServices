package ai.datank.pollAdd.api.model

import org.hibernate.validator.constraints.NotBlank

class PollCommand {

    @NotBlank
    String name
}
