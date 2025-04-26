package ui.diseno.software.views.drawer;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import ui.diseno.software.views.forms.FormUsuario;
import ui.diseno.software.views.tabbed.WindowsTabbed;
import raven.drawer.component.SimpleDrawerBuilder;
import raven.drawer.component.footer.SimpleFooterData;
import raven.drawer.component.header.SimpleHeaderData;
import raven.drawer.component.menu.MenuAction;
import raven.drawer.component.menu.MenuEvent;
import raven.drawer.component.menu.MenuValidation;
import raven.drawer.component.menu.SimpleMenuOption;
import raven.swing.AvatarIcon;
import ui.diseno.software.views.forms.FormCategorias;
import ui.diseno.software.views.forms.FormMarcas;
import ui.diseno.software.views.forms.FormProductos;
import ui.diseno.software.views.forms.FormRol;

/**
 *
 * @author Gabriel
 */
public class MyDrawerBuilder extends SimpleDrawerBuilder {

    @Override
    public SimpleHeaderData getSimpleHeaderData() {
        return new SimpleHeaderData()
                .setIcon(new AvatarIcon(getClass().getResource("/ui/diseno/software/views/images/profile.png"), 60, 60, 999))
                .setTitle("Administrador")
                .setDescription("descripcion");
    }

    @Override
    public SimpleMenuOption getSimpleMenuOption() {
        String menus[][] = {
            {"~PRINCIPAL~"},
            {"Adimistrar Usuarios", "Usuarios", "Roles"},
            {"~METODOS DE PAGO~"},
            {"Administrar metodos de pago"},
            {"~PRODUCTOS~"},
            {"Administrar Productos", "Productos", "Categorias", "Marcas"},
            {"Cerrar Sesion"}};

        String icons[] = {
            "user-plus.svg",
            "credit-card-pay.svg",
            "prong.svg",
            "logout.svg"};

        return new SimpleMenuOption()
                .setMenus(menus)
                .setIcons(icons)
                .setBaseIconPath("ui/diseno/software/views/drawer/icon")
                .setIconScale(1f)
                .addMenuEvent(new MenuEvent() {
                    @Override
                    public void selected(MenuAction action, int index, int subIndex) {
                        if (index == 0) {
                            if (subIndex == 1) {
                                WindowsTabbed.getInstance().addTab("Adiministar Usuarios", new FormUsuario());
                            } else if (subIndex == 2) {
                                WindowsTabbed.getInstance().addTab("Administrar Roles", new FormRol());
                            }
                        } else if (index == 2) {
                            if (subIndex == 1) {
                                
                                // VENTANA DE PRODUCTOS
                                WindowsTabbed.getInstance().addTab("Administrar Productos", new FormProductos());

                            } else if (subIndex == 2) {
                                
                                // VENTANA DE CATEGORIAS
                                WindowsTabbed.getInstance().addTab("Administrar Categorias", new FormCategorias());

                            } else if (subIndex == 3) {

                                WindowsTabbed.getInstance().addTab("Administrar Marcas", new FormMarcas());

                            }
                        }
                        System.out.println("Menu selected " + index + " " + subIndex);
                    }

                })
                .setMenuValidation(new MenuValidation() {
                    @Override
                    public boolean menuValidation(int index, int subIndex) {
//                        if(index == 0) {
//                            return false;
//                        } else if(index == 3){
//                            return false;
//                        }
                        return true;
                    }
                });
    }

    @Override
    public SimpleFooterData getSimpleFooterData() {
        return new SimpleFooterData()
                .setTitle("Java Swing Drawer")
                .setDescription("Version 1.1.0");
    }

}
