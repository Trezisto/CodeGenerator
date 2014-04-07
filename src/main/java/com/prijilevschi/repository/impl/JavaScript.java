package com.prijilevschi.repository.impl;

import org.springframework.stereotype.Repository;

import com.prijilevschi.repository.Language;

@Repository
public class JavaScript implements Language {

	public String getFileFormat() {
		return ".js";
	}

}
