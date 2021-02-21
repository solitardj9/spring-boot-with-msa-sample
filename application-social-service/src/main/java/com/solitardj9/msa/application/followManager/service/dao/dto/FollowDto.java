package com.solitardj9.msa.application.followManager.service.dao.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "follow")
@IdClass(FollowPK.class)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FollowDto implements Serializable {

	private static final long serialVersionUID = -1496038274327634951L;

	@Id
	@Column(name="followee_id")
	private Long followeeId;
	
	@Id
	@Column(name="follower_id")
	private Long followerId;
	
	@Column(name="created_at")
	private Date createdAt;
	
	public FollowDto(Long followeeId, Long followerId) {
		this.followeeId = followeeId;
		this.followerId = followerId;
		this.createdAt = new Date();
	}
}