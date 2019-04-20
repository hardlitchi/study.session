package io.github.hardlitchi.rest.common.entity;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 【Entityクラス】
 * <br>
 * 呼称情報.
 * @author hardlitchi
 * @version 1.0
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(callSuper=true)
@Entity
public class Name extends AbstractEntity implements Serializable {

	/** シリアルバージョン. */
	private static final long serialVersionUID = 4221109910584867721L;

	/** ID(内部識別子). */
	@Id
	@GeneratedValue
	private final String id = UUID.randomUUID().toString();
	/** 外部キー紐づけ先. */
	private String type;
	/** 外部キー. */
	private String extractid;
	/** 呼称. */
	private String name;
	/** 所有者属性. */
	private String ownerattribute;
	/** 所有者. */
	private String ownerid;
	/** 呼称公開設定ID. */
	private String nameflag;
}
