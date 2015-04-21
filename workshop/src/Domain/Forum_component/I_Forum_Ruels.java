package Domain.Forum_component;

public interface I_Forum_Ruels {

	public abstract Boolean getGuest_can_post();

	/* (non-Javadoc)
	 * @see Domain.Forum_component.I_Forum_Ruels#setGuest_can_post(java.lang.Boolean)
	 */

	public abstract void setGuest_can_post(Boolean guest_can_post);

	/* (non-Javadoc)
	 * @see Domain.Forum_component.I_Forum_Ruels#getMember_can_post()
	 */

	public abstract Boolean getMember_can_post();

	/* (non-Javadoc)
	 * @see Domain.Forum_component.I_Forum_Ruels#setMember_can_post(java.lang.Boolean)
	 */

	public abstract void setMember_can_post(Boolean member_can_post);

	/* (non-Javadoc)
	 * @see Domain.Forum_component.I_Forum_Ruels#getMember_can_reply()
	 */

	public abstract Boolean getMember_can_reply();

	/* (non-Javadoc)
	 * @see Domain.Forum_component.I_Forum_Ruels#setMember_can_reply(java.lang.Boolean)
	 */

	public abstract void setMember_can_reply(Boolean member_can_reply);

	/* (non-Javadoc)
	 * @see Domain.Forum_component.I_Forum_Ruels#getGuest_can_reply()
	 */

	public abstract Boolean getGuest_can_reply();

	/* (non-Javadoc)
	 * @see Domain.Forum_component.I_Forum_Ruels#setGuest_can_reply(java.lang.Boolean)
	 */

	public abstract void setGuest_can_reply(Boolean guest_can_reply);

	/* (non-Javadoc)
	 * @see Domain.Forum_component.I_Forum_Ruels#getMember_can_edit_post()
	 */

	public abstract Boolean getMember_can_edit_post();

	/* (non-Javadoc)
	 * @see Domain.Forum_component.I_Forum_Ruels#setMember_can_edit_post(java.lang.Boolean)
	 */

	public abstract void setMember_can_edit_post(Boolean member_can_edit_post);

	/* (non-Javadoc)
	 * @see Domain.Forum_component.I_Forum_Ruels#getGuest_can_edit_post()
	 */

	public abstract Boolean getGuest_can_edit_post();

	/* (non-Javadoc)
	 * @see Domain.Forum_component.I_Forum_Ruels#setGuest_can_edit_post(java.lang.Boolean)
	 */

	public abstract void setGuest_can_edit_post(Boolean guest_can_edit_post);

	/* (non-Javadoc)
	 * @see Domain.Forum_component.I_Forum_Ruels#getModerator_can_edit_post()
	 */

	public abstract Boolean getModerator_can_edit_post();

	/* (non-Javadoc)
	 * @see Domain.Forum_component.I_Forum_Ruels#setModerator_can_edit_post(java.lang.Boolean)
	 */

	public abstract void setModerator_can_edit_post(
			Boolean moderator_can_edit_post);

	/* (non-Javadoc)
	 * @see Domain.Forum_component.I_Forum_Ruels#getAdmin_can_edit_post()
	 */

	public abstract Boolean getAdmin_can_edit_post();

	/* (non-Javadoc)
	 * @see Domain.Forum_component.I_Forum_Ruels#setAdmin_can_edit_post(java.lang.Boolean)
	 */

	public abstract void setAdmin_can_edit_post(Boolean admin_can_edit_post);

	/* (non-Javadoc)
	 * @see Domain.Forum_component.I_Forum_Ruels#getGuest_can_delete_post()
	 */

	public abstract Boolean getGuest_can_delete_post();

	/* (non-Javadoc)
	 * @see Domain.Forum_component.I_Forum_Ruels#setGuest_can_delete_post(java.lang.Boolean)
	 */

	public abstract void setGuest_can_delete_post(Boolean guest_can_delete_post);

	/* (non-Javadoc)
	 * @see Domain.Forum_component.I_Forum_Ruels#getMember_can_delete_post()
	 */

	public abstract Boolean getMember_can_delete_post();

	/* (non-Javadoc)
	 * @see Domain.Forum_component.I_Forum_Ruels#setMember_can_delete_post(java.lang.Boolean)
	 */

	public abstract void setMember_can_delete_post(
			Boolean member_can_delete_post);

	/* (non-Javadoc)
	 * @see Domain.Forum_component.I_Forum_Ruels#getModerator_can_delete_post()
	 */

	public abstract Boolean getModerator_can_delete_post();

	/* (non-Javadoc)
	 * @see Domain.Forum_component.I_Forum_Ruels#setModerator_can_delete_post(java.lang.Boolean)
	 */

	public abstract void setModerator_can_delete_post(
			Boolean moderator_can_delete_post);

	/* (non-Javadoc)
	 * @see Domain.Forum_component.I_Forum_Ruels#getAdmin_can_delete_post()
	 */

	public abstract Boolean getAdmin_can_delete_post();

	/* (non-Javadoc)
	 * @see Domain.Forum_component.I_Forum_Ruels#setAdmin_can_delete_post(java.lang.Boolean)
	 */

	public abstract void setAdmin_can_delete_post(Boolean admin_can_delete_post);

	/* (non-Javadoc)
	 * @see Domain.Forum_component.I_Forum_Ruels#getAdmin_can_switch_admin()
	 */

	public abstract Boolean getAdmin_can_switch_admin();

	/* (non-Javadoc)
	 * @see Domain.Forum_component.I_Forum_Ruels#setAdmin_can_switch_admin(java.lang.Boolean)
	 */

	public abstract void setAdmin_can_switch_admin(
			Boolean admin_can_switch_admin);

	/* (non-Javadoc)
	 * @see Domain.Forum_component.I_Forum_Ruels#getAdmin_can_switch_moderator()
	 */

	public abstract Boolean getAdmin_can_switch_moderator();

	/* (non-Javadoc)
	 * @see Domain.Forum_component.I_Forum_Ruels#setAdmin_can_switch_moderator(java.lang.Boolean)
	 */

	public abstract void setAdmin_can_switch_moderator(
			Boolean admin_can_switch_moderator);

	/* (non-Javadoc)
	 * @see Domain.Forum_component.I_Forum_Ruels#getModerator_can_switch_moderator()
	 */

	public abstract Boolean getModerator_can_switch_moderator();

	/* (non-Javadoc)
	 * @see Domain.Forum_component.I_Forum_Ruels#setModerator_can_switch_moderator(java.lang.Boolean)
	 */

	public abstract void setModerator_can_switch_moderator(
			Boolean moderator_can_switch_moderator);

	/* (non-Javadoc)
	 * @see Domain.Forum_component.I_Forum_Ruels#getMember_can_add_sub_forum()
	 */

	public abstract Boolean getMember_can_add_sub_forum();

	/* (non-Javadoc)
	 * @see Domain.Forum_component.I_Forum_Ruels#setMember_can_add_sub_forum(java.lang.Boolean)
	 */

	public abstract void setMember_can_add_sub_forum(
			Boolean member_can_add_sub_forum);

	/* (non-Javadoc)
	 * @see Domain.Forum_component.I_Forum_Ruels#getAdmin_can_add_sub_forum()
	 */

	public abstract Boolean getAdmin_can_add_sub_forum();

	/* (non-Javadoc)
	 * @see Domain.Forum_component.I_Forum_Ruels#setAdmin_can_add_sub_forum(java.lang.Boolean)
	 */

	public abstract void setAdmin_can_add_sub_forum(
			Boolean admin_can_add_sub_forum);

	/* (non-Javadoc)
	 * @see Domain.Forum_component.I_Forum_Ruels#getAdmin_can_delete_sub_forum()
	 */

	public abstract Boolean getAdmin_can_delete_sub_forum();

	/* (non-Javadoc)
	 * @see Domain.Forum_component.I_Forum_Ruels#setAdmin_can_delete_sub_forum(java.lang.Boolean)
	 */

	public abstract void setAdmin_can_delete_sub_forum(
			Boolean admin_can_delete_sub_forum);

	/* (non-Javadoc)
	 * @see Domain.Forum_component.I_Forum_Ruels#getModerator_can_delete_sub_forum()
	 */

	public abstract Boolean getModerator_can_delete_sub_forum();

	/* (non-Javadoc)
	 * @see Domain.Forum_component.I_Forum_Ruels#setModerator_can_delete_sub_forum(java.lang.Boolean)
	 */

	public abstract void setModerator_can_delete_sub_forum(
			Boolean moderator_can_delete_sub_forum);

	/* (non-Javadoc)
	 * @see Domain.Forum_component.I_Forum_Ruels#getAdmin_can_add_moderator()
	 */

	public abstract Boolean getAdmin_can_add_moderator();

	/* (non-Javadoc)
	 * @see Domain.Forum_component.I_Forum_Ruels#setAdmin_can_add_moderator(java.lang.Boolean)
	 */

	public abstract void setAdmin_can_add_moderator(
			Boolean admin_can_add_moderator);

	/* (non-Javadoc)
	 * @see Domain.Forum_component.I_Forum_Ruels#getModerator_can_add_moderator()
	 */

	public abstract Boolean getModerator_can_add_moderator();

	/* (non-Javadoc)
	 * @see Domain.Forum_component.I_Forum_Ruels#setModerator_can_add_moderator(java.lang.Boolean)
	 */

	public abstract void setModerator_can_add_moderator(
			Boolean moderator_can_add_moderator);

	/* (non-Javadoc)
	 * @see Domain.Forum_component.I_Forum_Ruels#getModerator_can_suspend_moderator()
	 */

	public abstract Boolean getModerator_can_suspend_moderator();

	/* (non-Javadoc)
	 * @see Domain.Forum_component.I_Forum_Ruels#setModerator_can_suspend_moderator(java.lang.Boolean)
	 */

	public abstract void setModerator_can_suspend_moderator(
			Boolean moderator_can_suspend_moderator);

	/* (non-Javadoc)
	 * @see Domain.Forum_component.I_Forum_Ruels#getModerator_can_suspend_member()
	 */

	public abstract Boolean getModerator_can_suspend_member();

	/* (non-Javadoc)
	 * @see Domain.Forum_component.I_Forum_Ruels#setModerator_can_suspend_member(java.lang.Boolean)
	 */

	public abstract void setModerator_can_suspend_member(
			Boolean moderator_can_suspend_member);

	/* (non-Javadoc)
	 * @see Domain.Forum_component.I_Forum_Ruels#getAdmin_can_suspend_admin()
	 */

	public abstract Boolean getAdmin_can_suspend_admin();

	/* (non-Javadoc)
	 * @see Domain.Forum_component.I_Forum_Ruels#setAdmin_can_suspend_admin(java.lang.Boolean)
	 */

	public abstract void setAdmin_can_suspend_admin(
			Boolean admin_can_suspend_admin);

	/* (non-Javadoc)
	 * @see Domain.Forum_component.I_Forum_Ruels#getAdmin_can_suspend_moderator()
	 */

	public abstract Boolean getAdmin_can_suspend_moderator();

	/* (non-Javadoc)
	 * @see Domain.Forum_component.I_Forum_Ruels#setAdmin_can_suspend_moderator(java.lang.Boolean)
	 */

	public abstract void setAdmin_can_suspend_moderator(
			Boolean admin_can_suspend_moderator);

	/* (non-Javadoc)
	 * @see Domain.Forum_component.I_Forum_Ruels#getModerator_can_remove_moderator()
	 */

	public abstract Boolean getModerator_can_remove_moderator();

	/* (non-Javadoc)
	 * @see Domain.Forum_component.I_Forum_Ruels#setModerator_can_remove_moderator(java.lang.Boolean)
	 */

	public abstract void setModerator_can_remove_moderator(
			Boolean moderator_can_remove_moderator);

	/* (non-Javadoc)
	 * @see Domain.Forum_component.I_Forum_Ruels#getModerator_can_remove_member()
	 */

	public abstract Boolean getModerator_can_remove_member();

	/* (non-Javadoc)
	 * @see Domain.Forum_component.I_Forum_Ruels#setModerator_can_remove_member(java.lang.Boolean)
	 */

	public abstract void setModerator_can_remove_member(
			Boolean moderator_can_remove_member);

	public abstract int getNumberOfModerators();

	public abstract void setNumberOfModerators(int numberOfModerators);

	public abstract String getPasswordStrengh();

	public abstract void setPasswordStrengh(String passwordStrengh);

}