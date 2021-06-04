package controller;

import gui.AccountStudentjPn;
import gui.DSHPjPn;
import gui.DanhMuc;
import gui.RegisterjPn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public class ScreenController {
    private JPanel jpbView;
    private String kindSelected = "";
    List<DanhMuc> listDanhMuc = null;

    public ScreenController(JPanel jpbView) {
        this.jpbView = jpbView;
    }

    public void setDashboard(JPanel jpnItem, JLabel jlbItem) {
        kindSelected = "Account";
        jpnItem.setBackground(new Color(175, 177, 179));
        jlbItem.setBackground(new Color(175, 177, 179));
        JPanel node = new AccountStudentjPn();
        jpbView.removeAll();
        //jpbView.setLayout(new SpringLayout());
        jpbView.add(node);
        jpbView.validate();
        jpbView.repaint();
    }

    public void setEvent(java.util.List<DanhMuc> listDanhMuc) {
        this.listDanhMuc = listDanhMuc;
        for (DanhMuc item : listDanhMuc) {
            item.getJlb().addMouseListener(new LabelEvent(item.getKind(), item.getJpn(), item.getJlb()));
        }
    }

    class LabelEvent implements MouseListener {

        private JPanel node;
        private String kind;

        private JPanel jpnItem;
        private JLabel jlbItem;

        public LabelEvent(String kind, JPanel jpnItem, JLabel jlbItem) {
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            switch (kind) {
                case "Account":
                    node = new AccountStudentjPn();
                    break;
                case "DSHP":
                    node = new DSHPjPn();
                    break;
                case "Register":
                    node = new RegisterjPn();
                    break;
                default:
                    break;
            }
            jpbView.removeAll();
            jpbView.setLayout(new BorderLayout());
            jpbView.add(node);
            jpbView.validate();
            jpbView.repaint();
            setChangeBackground(kind);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            kindSelected = kind;
            jpnItem.setBackground(new Color(175, 177, 179));
            jlbItem.setBackground(new Color(175, 177, 179));
        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            jpnItem.setBackground(new Color(175, 177, 179));
            jlbItem.setBackground(new Color(175, 177, 179));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (!kindSelected.equalsIgnoreCase(kind)) {
                jpnItem.setBackground(new Color(238, 238, 238));
                jlbItem.setBackground(new Color(238, 238, 238));
            }
        }

    }
    private void setChangeBackground(String kind){
        for (DanhMuc item:listDanhMuc){
            if(item.getKind().equalsIgnoreCase(kind)){
                item.getJpn().setBackground(new Color(175,177,179));
                item.getJlb().setBackground(new Color(177,175,179));
            }
            else{

                item.getJpn().setBackground(new Color(238,238,238));
                item.getJlb().setBackground(new Color(238,238,238));
            }
        }
    }
}
