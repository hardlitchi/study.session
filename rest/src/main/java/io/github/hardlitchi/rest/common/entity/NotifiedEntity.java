package io.github.hardlitchi.rest.common.entity;

import java.sql.Timestamp;

/**
 * 通知対象が継承するInterface.
 * @author hardlitchi
 * @version 1.0
 */
public interface NotifiedEntity {

	/** ID. */
	public String getId();
	/** 情報区分. */
	public String getNotifiedentitytype();
	/** 宛先タイプ. */
	public String getDestinationtype();
	/** 宛先. */
	public String getDestination();
	/** 通知日時. */
	public Timestamp getSenddatetime();
}
