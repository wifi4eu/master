package wifi4eu.wifi4eu.repository.invitationContacts;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import wifi4eu.wifi4eu.entity.invitationContacts.InvitationContact;

import java.util.List;

public interface InvitationContactRepository extends CrudRepository<InvitationContact,Integer> {

    InvitationContact findByEmailInvitedAndIdUserRequestNotIn(String emailInvited, int idUserRequest);

    InvitationContact findByEmailInvitedAndIdUserRequest(String emailInvited, int idUserRequest);

    InvitationContact findByEmailInvitedAndStatus(String emailInvited, int status);

    List<InvitationContact> findByIdRegistration(Integer registrationId);

    List<InvitationContact> findByEmailInvited(String email);

}

