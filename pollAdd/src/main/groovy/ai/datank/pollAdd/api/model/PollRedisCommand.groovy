package ai.datank.pollAdd.api.model

import org.hibernate.validator.constraints.NotBlank
import org.hibernate.validator.constraints.NotEmpty

class PollRedisCommand {

    @NotBlank
    String id

    @NotBlank
    String user

    @NotBlank
    String pollName

    @NotEmpty
    List<String> pollOptions
}
