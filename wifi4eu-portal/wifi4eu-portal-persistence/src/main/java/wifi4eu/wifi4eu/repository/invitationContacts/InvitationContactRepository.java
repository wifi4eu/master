package wifi4eu.wifi4eu.repository.invitationContacts;

import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.invitationContacts.InvitationContact;

public interface InvitationContactRepository extends CrudRepository<InvitationContact,Integer> {

    InvitationContact findByEmailInvitedAndIdUserRequestNotIn(String emailInvited, int idUserRequest);

    InvitationContact findByEmailInvitedAndIdUserRequest(String emailInvited, int idUserRequest);

}

