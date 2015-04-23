package Domain.Forum_component;

import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

import Domain.User_component.Member;
import Domain.User_component.User;

public class Sub_Forum {
	private String subject;
	private String name;
	private Vector<Member> moderators; // suspended moderators are not removed
										// from moderators, only added and
										// removed from suspended_Moderators;
	private Vector<Member> suspended_Moderators;
	private Vector<Post> threads;
	private Forum forum;
	private Logger Alogger;
	private Logger Elogger;

	public Sub_Forum(String name, String subject, Vector<Member> moderators,
			Forum forum) {
		this.name = name;
		this.subject = subject;
		this.moderators = moderators;
		this.suspended_Moderators = new Vector<Member>();
		this.threads = new Vector<Post>();
		this.forum = forum;
		this.Alogger = Logger.getLogger("Action logger");
		this.Elogger = Logger.getLogger("Error logger");
	
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Vector<Member> getSuspended_Moderators() {
		return suspended_Moderators;
	}

	public Vector<Member> getModerators() {
		return moderators;
	}

	public void add_Moderator(Member moderator) {
		this.moderators.add(moderator);
	}

	public Vector<Post> getThreads() {
		return threads;
	}

	public Post add_thread(String header, String body, User u) {
		if (header == "" || body == "")
			try {
				throw new Exception("body or header are empty");
			} catch (Exception e) {
				return null;
			}
		Post p = new Post(header, body, u, null, this);
		this.threads.add(p);
		if (u instanceof Member)
			((Member) u).get_MemberInForum(forum).addPost();
		return p;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Member has_moderator(String mod_name) {
		for (Member mod : this.moderators)
			if (mod.getName().equals(mod_name))
				return mod;
		return null;
	}

	public Member has_moderator(Member mod) {
		for (Member m : this.moderators)
			if (m.equals(mod))
				return mod;
		return null;
	}

	public boolean add_Suspended_Moderator(String mod_name) {
		for (Member mod : this.moderators)
			if (mod.getName().equals(mod_name)) {
				this.suspended_Moderators.add(mod);
				return true;
			}
		return false;
	}

	public Member has_suspended_moderator(String mod_name) {
		for (Member mod : this.suspended_Moderators)
			if (mod.getName().equals(mod_name))
				return mod;
		return null;
	}

	public boolean sendComplaint(Member member, String Complaint,
			Member moderator) {
		if (Complaint == "" || moderator == null)
			try {
				throw new Exception("fields are missing");
			} catch (Exception e) {
				return false;
			}
		boolean flage = false;
		if (moderators.contains(moderator))
			for (Post thread : threads) {
				if (thread.isAuthor(member))
					flage = true;
				Vector<Post> kids = thread.getKids();
				if (!flage)
					flage = isAuthor(kids, member);
			}
		if (flage) {
			Alogger.log(Level.INFO, "Complaint about " + moderator.getName()
					+ " submitted successfully");
			return true;
		}
		Elogger.log(Level.WARNING,
				"You can't complaint about " + moderator.getName());
		return false;

	}

	public boolean isAuthor(Vector<Post> kids, Member mem) {
		for (int i = 0; i < kids.size(); i++) {
			if (kids.get(i).isAuthor(mem))
				return true;
			if (kids.get(i).getKids() != null)
				return isAuthor(kids.get(i).getKids(), mem);
		}
		return false;
	}

	public Forum getForum() {
		return this.forum;
	}
	

}