package com.team.LetsStudyNow_rg.domain.groupstudy.dto;

import com.team.LetsStudyNow_rg.domain.groupstudy.domain.StudyRoomParticipant;
import com.team.LetsStudyNow_rg.domain.member.entity.Member;
import java.time.LocalDateTime;

public class StudyRoomParticipantResponse {

    private Long id;                        // 참여자 ID
    private Long memberId;                  // 사용자 ID
    private String username;                // 사용자 이름
    private String profileImage;            // 프로필 이미지
    private LocalDateTime joinedAt;         // 입장 시간

    // 기본 생성자
    public StudyRoomParticipantResponse() {
    }

    // Entity → DTO 변환 (Member 정보 포함)
    public StudyRoomParticipantResponse(StudyRoomParticipant participant, Member member) {
        this.id = participant.getId();
        this.memberId = participant.getMemberId();
        this.username = member.getUsername();
        this.profileImage = member.getProfileImage();
        this.joinedAt = participant.getJoinedAt();
    }

    // Getter
    public Long getId() {
        return id;
    }

    public Long getMemberId() {
        return memberId;
    }

    public String getUsername() {
        return username;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public LocalDateTime getJoinedAt() {
        return joinedAt;
    }
}
