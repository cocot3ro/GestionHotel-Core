package com.cocot3ro.gestionhotel.msvc.almacen.persistence

import com.cocot3ro.gestionhotel.msvc.almacen.entities.AlmacenEntity
import org.springframework.data.jpa.repository.JpaRepository

interface AlmacenJPARepository : JpaRepository<AlmacenEntity, Long>