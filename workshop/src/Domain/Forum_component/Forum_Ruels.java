package Domain.Forum_component;

public class Forum_Ruels {
	private Boolean guest_can_post;
	private Boolean member_can_post;
	private Boolean member_can_reply;
	private Boolean guest_can_reply;
	private Boolean member_can_edit_post;
	private Boolean guest_can_edit_post;
	private Boolean moderator_can_edit_post;
	private Boolean admin_can_edit_post;
	private Boolean guest_can_delete_post;
	private Boolean member_can_delete_post;
	private Boolean moderator_can_delete_post;
	private Boolean admin_can_delete_post;
	private Boolean admin_can_switch_admin;
	private Boolean admin_can_switch_moderator;
	private Boolean moderator_can_switch_moderator;
	private Boolean member_can_add_sub_forum;
	private Boolean admin_can_add_sub_forum;
	private Boolean admin_can_delete_sub_forum;
	private Boolean moderator_can_delete_sub_forum;
	private Boolean admin_can_add_moderator;
	private Boolean moderator_can_add_moderator;
	private Boolean moderator_can_suspend_moderator;
	private Boolean moderator_can_suspend_member;
	private Boolean admin_can_suspend_admin;
	private Boolean admin_can_suspend_moderator;
	private Boolean moderator_can_remove_moderator;
	private Boolean moderator_can_remove_member;
	private int numberOfModerators;
	private String passwordStrengh;

	public Forum_Ruels() {
		// first set all to true, than can be changed by set
		guest_can_post = true;
		member_can_post = true;
		member_can_reply = true;
		guest_can_reply = true;
		member_can_edit_post = true;
		guest_can_edit_post = true;
		moderator_can_edit_post = true;
		admin_can_edit_post = true;
		guest_can_delete_post = true;
		member_can_delete_post = true;
		moderator_can_delete_post = true;
		admin_can_delete_post = true;
		admin_can_switch_admin = true;
		admin_can_switch_moderator = true;
		moderator_can_switch_moderator = true;
		member_can_add_sub_forum = true;
		admin_can_add_sub_forum = true;
		admin_can_delete_sub_forum = true;
		moderator_can_delete_sub_forum = true;
		admin_can_add_moderator = true;
		moderator_can_add_moderator = true;
		moderator_can_suspend_moderator = true;
		moderator_can_suspend_member = true;
		admin_can_suspend_admin = true;
		admin_can_suspend_moderator = true;
		moderator_can_remove_moderator = true;
		moderator_can_remove_member = true;
		numberOfModerators = 1;
		passwordStrengh = "There is no limitations";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Domain.Forum_component.I_Forum_Ruels#getGuest_can_post()
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see Domain.Forum_component.I_Forum_Ruels#getGuest_can_post()
	 */

	public Boolean getGuest_can_post() {
		return guest_can_post;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * Domain.Forum_component.I_Forum_Ruels#setGuest_can_post(java.lang.Boolean)
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * Domain.Forum_component.I_Forum_Ruels#setGuest_can_post(java.lang.Boolean)
	 */

	public void setGuest_can_post(Boolean guest_can_post) {
		this.guest_can_post = guest_can_post;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Domain.Forum_component.I_Forum_Ruels#getMember_can_post()
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see Domain.Forum_component.I_Forum_Ruels#getMember_can_post()
	 */

	public Boolean getMember_can_post() {
		return member_can_post;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * Domain.Forum_component.I_Forum_Ruels#setMember_can_post(java.lang.Boolean
	 * )
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * Domain.Forum_component.I_Forum_Ruels#setMember_can_post(java.lang.Boolean
	 * )
	 */

	public void setMember_can_post(Boolean member_can_post) {
		this.member_can_post = member_can_post;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Domain.Forum_component.I_Forum_Ruels#getMember_can_reply()
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see Domain.Forum_component.I_Forum_Ruels#getMember_can_reply()
	 */

	public Boolean getMember_can_reply() {
		return member_can_reply;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * Domain.Forum_component.I_Forum_Ruels#setMember_can_reply(java.lang.Boolean
	 * )
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * Domain.Forum_component.I_Forum_Ruels#setMember_can_reply(java.lang.Boolean
	 * )
	 */

	public void setMember_can_reply(Boolean member_can_reply) {
		this.member_can_reply = member_can_reply;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Domain.Forum_component.I_Forum_Ruels#getGuest_can_reply()
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see Domain.Forum_component.I_Forum_Ruels#getGuest_can_reply()
	 */

	public Boolean getGuest_can_reply() {
		return guest_can_reply;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * Domain.Forum_component.I_Forum_Ruels#setGuest_can_reply(java.lang.Boolean
	 * )
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * Domain.Forum_component.I_Forum_Ruels#setGuest_can_reply(java.lang.Boolean
	 * )
	 */

	public void setGuest_can_reply(Boolean guest_can_reply) {
		this.guest_can_reply = guest_can_reply;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Domain.Forum_component.I_Forum_Ruels#getMember_can_edit_post()
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see Domain.Forum_component.I_Forum_Ruels#getMember_can_edit_post()
	 */

	public Boolean getMember_can_edit_post() {
		return member_can_edit_post;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * Domain.Forum_component.I_Forum_Ruels#setMember_can_edit_post(java.lang
	 * .Boolean)
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * Domain.Forum_component.I_Forum_Ruels#setMember_can_edit_post(java.lang
	 * .Boolean)
	 */

	public void setMember_can_edit_post(Boolean member_can_edit_post) {
		this.member_can_edit_post = member_can_edit_post;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Domain.Forum_component.I_Forum_Ruels#getGuest_can_edit_post()
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see Domain.Forum_component.I_Forum_Ruels#getGuest_can_edit_post()
	 */

	public Boolean getGuest_can_edit_post() {
		return guest_can_edit_post;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * Domain.Forum_component.I_Forum_Ruels#setGuest_can_edit_post(java.lang
	 * .Boolean)
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * Domain.Forum_component.I_Forum_Ruels#setGuest_can_edit_post(java.lang
	 * .Boolean)
	 */

	public void setGuest_can_edit_post(Boolean guest_can_edit_post) {
		this.guest_can_edit_post = guest_can_edit_post;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Domain.Forum_component.I_Forum_Ruels#getModerator_can_edit_post()
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see Domain.Forum_component.I_Forum_Ruels#getModerator_can_edit_post()
	 */

	public Boolean getModerator_can_edit_post() {
		return moderator_can_edit_post;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * Domain.Forum_component.I_Forum_Ruels#setModerator_can_edit_post(java.
	 * lang.Boolean)
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * Domain.Forum_component.I_Forum_Ruels#setModerator_can_edit_post(java.
	 * lang.Boolean)
	 */

	public void setModerator_can_edit_post(Boolean moderator_can_edit_post) {
		this.moderator_can_edit_post = moderator_can_edit_post;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Domain.Forum_component.I_Forum_Ruels#getAdmin_can_edit_post()
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see Domain.Forum_component.I_Forum_Ruels#getAdmin_can_edit_post()
	 */

	public Boolean getAdmin_can_edit_post() {
		return admin_can_edit_post;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * Domain.Forum_component.I_Forum_Ruels#setAdmin_can_edit_post(java.lang
	 * .Boolean)
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * Domain.Forum_component.I_Forum_Ruels#setAdmin_can_edit_post(java.lang
	 * .Boolean)
	 */

	public void setAdmin_can_edit_post(Boolean admin_can_edit_post) {
		this.admin_can_edit_post = admin_can_edit_post;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Domain.Forum_component.I_Forum_Ruels#getGuest_can_delete_post()
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see Domain.Forum_component.I_Forum_Ruels#getGuest_can_delete_post()
	 */

	public Boolean getGuest_can_delete_post() {
		return guest_can_delete_post;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * Domain.Forum_component.I_Forum_Ruels#setGuest_can_delete_post(java.lang
	 * .Boolean)
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * Domain.Forum_component.I_Forum_Ruels#setGuest_can_delete_post(java.lang
	 * .Boolean)
	 */

	public void setGuest_can_delete_post(Boolean guest_can_delete_post) {
		this.guest_can_delete_post = guest_can_delete_post;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Domain.Forum_component.I_Forum_Ruels#getMember_can_delete_post()
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see Domain.Forum_component.I_Forum_Ruels#getMember_can_delete_post()
	 */

	public Boolean getMember_can_delete_post() {
		return member_can_delete_post;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * Domain.Forum_component.I_Forum_Ruels#setMember_can_delete_post(java.lang
	 * .Boolean)
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * Domain.Forum_component.I_Forum_Ruels#setMember_can_delete_post(java.lang
	 * .Boolean)
	 */

	public void setMember_can_delete_post(Boolean member_can_delete_post) {
		this.member_can_delete_post = member_can_delete_post;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Domain.Forum_component.I_Forum_Ruels#getModerator_can_delete_post()
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see Domain.Forum_component.I_Forum_Ruels#getModerator_can_delete_post()
	 */

	public Boolean getModerator_can_delete_post() {
		return moderator_can_delete_post;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * Domain.Forum_component.I_Forum_Ruels#setModerator_can_delete_post(java
	 * .lang.Boolean)
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * Domain.Forum_component.I_Forum_Ruels#setModerator_can_delete_post(java
	 * .lang.Boolean)
	 */

	public void setModerator_can_delete_post(Boolean moderator_can_delete_post) {
		this.moderator_can_delete_post = moderator_can_delete_post;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Domain.Forum_component.I_Forum_Ruels#getAdmin_can_delete_post()
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see Domain.Forum_component.I_Forum_Ruels#getAdmin_can_delete_post()
	 */

	public Boolean getAdmin_can_delete_post() {
		return admin_can_delete_post;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * Domain.Forum_component.I_Forum_Ruels#setAdmin_can_delete_post(java.lang
	 * .Boolean)
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * Domain.Forum_component.I_Forum_Ruels#setAdmin_can_delete_post(java.lang
	 * .Boolean)
	 */

	public void setAdmin_can_delete_post(Boolean admin_can_delete_post) {
		this.admin_can_delete_post = admin_can_delete_post;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Domain.Forum_component.I_Forum_Ruels#getAdmin_can_switch_admin()
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see Domain.Forum_component.I_Forum_Ruels#getAdmin_can_switch_admin()
	 */

	public Boolean getAdmin_can_switch_admin() {
		return admin_can_switch_admin;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * Domain.Forum_component.I_Forum_Ruels#setAdmin_can_switch_admin(java.lang
	 * .Boolean)
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * Domain.Forum_component.I_Forum_Ruels#setAdmin_can_switch_admin(java.lang
	 * .Boolean)
	 */

	public void setAdmin_can_switch_admin(Boolean admin_can_switch_admin) {
		this.admin_can_switch_admin = admin_can_switch_admin;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Domain.Forum_component.I_Forum_Ruels#getAdmin_can_switch_moderator()
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see Domain.Forum_component.I_Forum_Ruels#getAdmin_can_switch_moderator()
	 */

	public Boolean getAdmin_can_switch_moderator() {
		return admin_can_switch_moderator;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * Domain.Forum_component.I_Forum_Ruels#setAdmin_can_switch_moderator(java
	 * .lang.Boolean)
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * Domain.Forum_component.I_Forum_Ruels#setAdmin_can_switch_moderator(java
	 * .lang.Boolean)
	 */

	public void setAdmin_can_switch_moderator(Boolean admin_can_switch_moderator) {
		this.admin_can_switch_moderator = admin_can_switch_moderator;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * Domain.Forum_component.I_Forum_Ruels#getModerator_can_switch_moderator()
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * Domain.Forum_component.I_Forum_Ruels#getModerator_can_switch_moderator()
	 */

	public Boolean getModerator_can_switch_moderator() {
		return moderator_can_switch_moderator;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * Domain.Forum_component.I_Forum_Ruels#setModerator_can_switch_moderator
	 * (java.lang.Boolean)
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * Domain.Forum_component.I_Forum_Ruels#setModerator_can_switch_moderator
	 * (java.lang.Boolean)
	 */

	public void setModerator_can_switch_moderator(
			Boolean moderator_can_switch_moderator) {
		this.moderator_can_switch_moderator = moderator_can_switch_moderator;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Domain.Forum_component.I_Forum_Ruels#getMember_can_add_sub_forum()
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see Domain.Forum_component.I_Forum_Ruels#getMember_can_add_sub_forum()
	 */

	public Boolean getMember_can_add_sub_forum() {
		return member_can_add_sub_forum;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * Domain.Forum_component.I_Forum_Ruels#setMember_can_add_sub_forum(java
	 * .lang.Boolean)
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * Domain.Forum_component.I_Forum_Ruels#setMember_can_add_sub_forum(java
	 * .lang.Boolean)
	 */

	public void setMember_can_add_sub_forum(Boolean member_can_add_sub_forum) {
		this.member_can_add_sub_forum = member_can_add_sub_forum;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Domain.Forum_component.I_Forum_Ruels#getAdmin_can_add_sub_forum()
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see Domain.Forum_component.I_Forum_Ruels#getAdmin_can_add_sub_forum()
	 */

	public Boolean getAdmin_can_add_sub_forum() {
		return admin_can_add_sub_forum;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * Domain.Forum_component.I_Forum_Ruels#setAdmin_can_add_sub_forum(java.
	 * lang.Boolean)
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * Domain.Forum_component.I_Forum_Ruels#setAdmin_can_add_sub_forum(java.
	 * lang.Boolean)
	 */

	public void setAdmin_can_add_sub_forum(Boolean admin_can_add_sub_forum) {
		this.admin_can_add_sub_forum = admin_can_add_sub_forum;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Domain.Forum_component.I_Forum_Ruels#getAdmin_can_delete_sub_forum()
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see Domain.Forum_component.I_Forum_Ruels#getAdmin_can_delete_sub_forum()
	 */

	public Boolean getAdmin_can_delete_sub_forum() {
		return admin_can_delete_sub_forum;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * Domain.Forum_component.I_Forum_Ruels#setAdmin_can_delete_sub_forum(java
	 * .lang.Boolean)
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * Domain.Forum_component.I_Forum_Ruels#setAdmin_can_delete_sub_forum(java
	 * .lang.Boolean)
	 */

	public void setAdmin_can_delete_sub_forum(Boolean admin_can_delete_sub_forum) {
		this.admin_can_delete_sub_forum = admin_can_delete_sub_forum;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * Domain.Forum_component.I_Forum_Ruels#getModerator_can_delete_sub_forum()
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * Domain.Forum_component.I_Forum_Ruels#getModerator_can_delete_sub_forum()
	 */

	public Boolean getModerator_can_delete_sub_forum() {
		return moderator_can_delete_sub_forum;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * Domain.Forum_component.I_Forum_Ruels#setModerator_can_delete_sub_forum
	 * (java.lang.Boolean)
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * Domain.Forum_component.I_Forum_Ruels#setModerator_can_delete_sub_forum
	 * (java.lang.Boolean)
	 */

	public void setModerator_can_delete_sub_forum(
			Boolean moderator_can_delete_sub_forum) {
		this.moderator_can_delete_sub_forum = moderator_can_delete_sub_forum;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Domain.Forum_component.I_Forum_Ruels#getAdmin_can_add_moderator()
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see Domain.Forum_component.I_Forum_Ruels#getAdmin_can_add_moderator()
	 */

	public Boolean getAdmin_can_add_moderator() {
		return admin_can_add_moderator;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * Domain.Forum_component.I_Forum_Ruels#setAdmin_can_add_moderator(java.
	 * lang.Boolean)
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * Domain.Forum_component.I_Forum_Ruels#setAdmin_can_add_moderator(java.
	 * lang.Boolean)
	 */

	public void setAdmin_can_add_moderator(Boolean admin_can_add_moderator) {
		this.admin_can_add_moderator = admin_can_add_moderator;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * Domain.Forum_component.I_Forum_Ruels#getModerator_can_add_moderator()
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * Domain.Forum_component.I_Forum_Ruels#getModerator_can_add_moderator()
	 */

	public Boolean getModerator_can_add_moderator() {
		return moderator_can_add_moderator;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * Domain.Forum_component.I_Forum_Ruels#setModerator_can_add_moderator(java
	 * .lang.Boolean)
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * Domain.Forum_component.I_Forum_Ruels#setModerator_can_add_moderator(java
	 * .lang.Boolean)
	 */

	public void setModerator_can_add_moderator(
			Boolean moderator_can_add_moderator) {
		this.moderator_can_add_moderator = moderator_can_add_moderator;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * Domain.Forum_component.I_Forum_Ruels#getModerator_can_suspend_moderator()
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * Domain.Forum_component.I_Forum_Ruels#getModerator_can_suspend_moderator()
	 */

	public Boolean getModerator_can_suspend_moderator() {
		return moderator_can_suspend_moderator;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * Domain.Forum_component.I_Forum_Ruels#setModerator_can_suspend_moderator
	 * (java.lang.Boolean)
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * Domain.Forum_component.I_Forum_Ruels#setModerator_can_suspend_moderator
	 * (java.lang.Boolean)
	 */

	public void setModerator_can_suspend_moderator(
			Boolean moderator_can_suspend_moderator) {
		this.moderator_can_suspend_moderator = moderator_can_suspend_moderator;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * Domain.Forum_component.I_Forum_Ruels#getModerator_can_suspend_member()
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * Domain.Forum_component.I_Forum_Ruels#getModerator_can_suspend_member()
	 */

	public Boolean getModerator_can_suspend_member() {
		return moderator_can_suspend_member;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * Domain.Forum_component.I_Forum_Ruels#setModerator_can_suspend_member(
	 * java.lang.Boolean)
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * Domain.Forum_component.I_Forum_Ruels#setModerator_can_suspend_member(
	 * java.lang.Boolean)
	 */

	public void setModerator_can_suspend_member(
			Boolean moderator_can_suspend_member) {
		this.moderator_can_suspend_member = moderator_can_suspend_member;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Domain.Forum_component.I_Forum_Ruels#getAdmin_can_suspend_admin()
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see Domain.Forum_component.I_Forum_Ruels#getAdmin_can_suspend_admin()
	 */

	public Boolean getAdmin_can_suspend_admin() {
		return admin_can_suspend_admin;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * Domain.Forum_component.I_Forum_Ruels#setAdmin_can_suspend_admin(java.
	 * lang.Boolean)
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * Domain.Forum_component.I_Forum_Ruels#setAdmin_can_suspend_admin(java.
	 * lang.Boolean)
	 */

	public void setAdmin_can_suspend_admin(Boolean admin_can_suspend_admin) {
		this.admin_can_suspend_admin = admin_can_suspend_admin;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * Domain.Forum_component.I_Forum_Ruels#getAdmin_can_suspend_moderator()
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * Domain.Forum_component.I_Forum_Ruels#getAdmin_can_suspend_moderator()
	 */

	public Boolean getAdmin_can_suspend_moderator() {
		return admin_can_suspend_moderator;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * Domain.Forum_component.I_Forum_Ruels#setAdmin_can_suspend_moderator(java
	 * .lang.Boolean)
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * Domain.Forum_component.I_Forum_Ruels#setAdmin_can_suspend_moderator(java
	 * .lang.Boolean)
	 */

	public void setAdmin_can_suspend_moderator(
			Boolean admin_can_suspend_moderator) {
		this.admin_can_suspend_moderator = admin_can_suspend_moderator;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * Domain.Forum_component.I_Forum_Ruels#getModerator_can_remove_moderator()
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * Domain.Forum_component.I_Forum_Ruels#getModerator_can_remove_moderator()
	 */

	public Boolean getModerator_can_remove_moderator() {
		return moderator_can_remove_moderator;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * Domain.Forum_component.I_Forum_Ruels#setModerator_can_remove_moderator
	 * (java.lang.Boolean)
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * Domain.Forum_component.I_Forum_Ruels#setModerator_can_remove_moderator
	 * (java.lang.Boolean)
	 */

	public void setModerator_can_remove_moderator(
			Boolean moderator_can_remove_moderator) {
		this.moderator_can_remove_moderator = moderator_can_remove_moderator;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * Domain.Forum_component.I_Forum_Ruels#getModerator_can_remove_member()
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * Domain.Forum_component.I_Forum_Ruels#getModerator_can_remove_member()
	 */

	public Boolean getModerator_can_remove_member() {
		return moderator_can_remove_member;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * Domain.Forum_component.I_Forum_Ruels#setModerator_can_remove_member(java
	 * .lang.Boolean)
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * Domain.Forum_component.I_Forum_Ruels#setModerator_can_remove_member(java
	 * .lang.Boolean)
	 */

	public void setModerator_can_remove_member(
			Boolean moderator_can_remove_member) {
		this.moderator_can_remove_member = moderator_can_remove_member;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Domain.Forum_component.I_Forum_Ruels#getNumberOfModerators()
	 */

	public int getNumberOfModerators() {
		return numberOfModerators;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Domain.Forum_component.I_Forum_Ruels#setNumberOfModerators(int)
	 */

	public void setNumberOfModerators(int numberOfModerators) {
		this.numberOfModerators = numberOfModerators;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Domain.Forum_component.I_Forum_Ruels#getPasswordStrengh()
	 */

	public String getPasswordStrengh() {
		return passwordStrengh;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * Domain.Forum_component.I_Forum_Ruels#setPasswordStrengh(java.lang.String)
	 */

	public void setPasswordStrengh(String passwordStrengh) {
		this.passwordStrengh = passwordStrengh;
	}

}
