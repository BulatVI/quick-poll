package com.example.quick_poll.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.hateoas.RepresentationModel;

import java.util.Set;


@Entity
public class Poll extends RepresentationModel<Poll>{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="POLL_ID")
	private Long id;
	
	@Column(name="QUESTION")
	@NotEmpty
	private String question;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="POLL_ID")
	@OrderBy
	@Size(min=2, max = 6)
	private Set<Option> options;

	public Long getPollId() {
		return id;
	}
	public void setPollId(Long id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public Set<Option> getOptions() {
		return options;
	}
	public void setOptions(Set<Option> options) {
		this.options = options;
	}
	
	@Override
	public String toString() {
		return getPollId() + ", " + getQuestion() + ", " + getOptions();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((question == null) ? 0 : question.hashCode());
		result = prime * result + ((options == null) ? 0 : options.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Poll other = (Poll) obj;
		if (question == null) {
			if (other.question != null)
				return false;
		} else if (!question.equals(other.question))
			return false;
		if (options == null) {
			if (other.options != null)
				return false;
		} else if (!options.equals(other.options))
			return false;
		return true;
	}
	
}