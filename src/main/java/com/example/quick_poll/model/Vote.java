package com.example.quick_poll.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.example.quick_poll.dto.VoteDTO;

@Entity
public class Vote {

    @Id
    @GeneratedValue
    @Column(name = "\"VOTE_ID")
    private long id;

    @ManyToOne
    @JoinColumn(name = "OPTION_ID")
    private Option option;    

    public Vote(VoteDTO voteDTO) {
        this.id = voteDTO.getId();
        this.option = voteDTO.getOption();
    }
    public Vote() {}
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public Option getOption() {
        return option;
    }
    public void setOption(Option option) {
        this.option = option;
    }
    @Override
	public String toString() {
		return getId() + ", " + getOption();
	}
}
