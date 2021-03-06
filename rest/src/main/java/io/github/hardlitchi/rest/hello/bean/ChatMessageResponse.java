package io.github.hardlitchi.rest.hello.bean;

import org.springframework.util.StringUtils;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.github.hardlitchi.rest.chat.entity.ChatMessage;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ChatMessageレスポンスBean.
 * @author hardlitchi
 * @version 1.0
 */
@Data
@NoArgsConstructor
public class ChatMessageResponse {

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String id;

	/** 宛先. */
	@ApiModelProperty(value = "宛先")
	private String toName;

	/** 送り主. */
	@ApiModelProperty(value = "送り主")
	private String fromName;

	/** CC先. */
	@ApiModelProperty(value = "CC先")
	private String ccName;

	/** BCC先. */
	@ApiModelProperty(value = "BCC先")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String bccName;

	/** タイトル. */
	@ApiModelProperty(value = "タイトル")
	private String title;

	/** 本文. */
	@ApiModelProperty(value = "本文")
	private String message;

	/** 作成日時. */
	@ApiModelProperty(value = "作成日時")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String createTimestamp;

	/** 更新日時. */
	@ApiModelProperty(value = "更新日時")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String updateTimestamp;

	/** 削除日時. */
	@ApiModelProperty(value = "削除日時")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String deleteTimestamp;

	/**
	 * EntityからResponseを生成する.
	 * @param chatMessage レスポンスBean
	 */
	public ChatMessageResponse(ChatMessage chatMessage) {
		this.id = StringUtils.isEmpty(chatMessage.getId()) ? null : String.valueOf(chatMessage.getId());
		this.title = StringUtils.isEmpty(chatMessage.getTitle()) ? "" : String.valueOf(chatMessage.getTitle());
		this.message = StringUtils.isEmpty(chatMessage.getMessage()) ? "" : String.valueOf(chatMessage.getMessage());
		this.createTimestamp = StringUtils.isEmpty(chatMessage.getCreateTimestamp()) ? null : String.valueOf(chatMessage.getCreateTimestamp());
		this.updateTimestamp = StringUtils.isEmpty(chatMessage.getUpdateTimestamp()) ? null : String.valueOf(chatMessage.getUpdateTimestamp());
		this.deleteTimestamp = StringUtils.isEmpty(chatMessage.getDeleteTimestamp()) ? null : String.valueOf(chatMessage.getDeleteTimestamp());
	}
}
