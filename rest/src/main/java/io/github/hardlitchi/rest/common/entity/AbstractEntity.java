package io.github.hardlitchi.rest.common.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@MappedSuperclass
public abstract class AbstractEntity implements Serializable {

	/** シリアルバージョン. */
	private static final long serialVersionUID = -1604614215038649739L;
	/** 作成日時. */
	private Timestamp createTimestamp;
	/** 更新日時. */
	private Timestamp updateTimestamp;
	/** 削除日時. */
	private Timestamp deleteTimestamp;

	public abstract String getId();
}
