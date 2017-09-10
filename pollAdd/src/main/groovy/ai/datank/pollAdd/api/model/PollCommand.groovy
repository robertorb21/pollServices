package ai.datank.pollAdd.api.model

import org.hibernate.validator.constraints.NotBlank
import org.hibernate.validator.constraints.NotEmpty

class PollCommand {

    @NotBlank
    String user

    @NotBlank
    String pollName

    @NotEmpty
    List<String> pollOptions
}
