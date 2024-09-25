package com.cocot3ro.gestionhotel.core.persistence

import com.cocot3ro.gestionhotel.core.entities.AlmacenEntity
import org.springframework.data.jpa.repository.JpaRepository

interface AlmacenJPARepository : JpaRepository<AlmacenEntity, Long>