/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.nooble.utsperpus.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Toshiba
 */
@Entity
public class Perpus {
    @Id
    @Getter @Setter
    private String id_buku;
    @Getter @Setter
    private String judul_buku;
    @Getter @Setter
    private String pengarang;
}
