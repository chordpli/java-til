package gomgomcup2th;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class C {

    static class Chong {
        private int chicken;
        private int pizza;
        private int hamburger;

        public int getChicken() {
            return chicken;
        }

        public void setChicken(int chicken) {
            this.chicken = chicken;
        }

        public int getPizza() {
            return pizza;
        }

        public void setPizza(int pizza) {
            this.pizza = pizza;
        }

        public int getHamburger() {
            return hamburger;
        }

        public void setHamburger(int hamburger) {
            this.hamburger = hamburger;
        }

        public Chong(int chicken, int pizza, int hamburger) {
            this.chicken = chicken;
            this.pizza = pizza;
            this.hamburger = hamburger;
        }
    }

    static class Ticket {
        private int cTicket;
        private int pTicket;
        private int hTicket;

        public Ticket(int cTicket, int pTicket, int hTicket) {
            this.cTicket = cTicket;
            this.pTicket = pTicket;
            this.hTicket = hTicket;
        }

        public int getcTicket() {
            return cTicket;
        }

        public void setcTicket(int cTicket) {
            this.cTicket = cTicket;
        }

        public int getpTicket() {
            return pTicket;
        }

        public void setpTicket(int pTicket) {
            this.pTicket = pTicket;
        }

        public int gethTicket() {
            return hTicket;
        }

        public void sethTicket(int hTicket) {
            this.hTicket = hTicket;
        }
    }

    public static void main(String[] args) throws IOException {
        int count = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Chong chong = new Chong(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        st = new StringTokenizer(br.readLine());
        Ticket ticket = new Ticket(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        if (chong.getChicken() >= ticket.getcTicket()) {
            count += ticket.getcTicket();
            chong.setChicken(chong.getChicken() - ticket.getcTicket());
            ticket.setcTicket(0);
        } else {
            count += chong.getChicken();
            ticket.setcTicket(ticket.getcTicket() - chong.getChicken());
            chong.setChicken(0);
        }

        if (chong.getPizza() >= ticket.getpTicket()) {
            count += ticket.getpTicket();
            chong.setPizza(chong.getPizza() - ticket.getpTicket());
            ticket.setpTicket(0);
        } else {
            count += chong.getPizza();
            ticket.setpTicket(ticket.getpTicket() - chong.getPizza());
            chong.setPizza(0);
        }

        if (chong.getHamburger() >= ticket.gethTicket()) {
            count += ticket.gethTicket();
            chong.setHamburger(chong.getHamburger() - ticket.gethTicket());
            ticket.sethTicket(0);
        } else {
            count += chong.getHamburger();
            ticket.sethTicket(ticket.gethTicket() - chong.getHamburger());
            chong.setHamburger(0);
        }


        for (int i = 0; i < 2; i++) {
            if (ticket.getcTicket() >= 3) {
                int temp = ticket.getcTicket() / 3;
                ticket.setpTicket(ticket.getpTicket() + temp);
                ticket.setcTicket(ticket.getcTicket() % 3);

                if (chong.getPizza() >= ticket.getpTicket()) {
                    count += ticket.getpTicket();
                    chong.setPizza(chong.getPizza() - ticket.getpTicket());
                    ticket.setpTicket(0);
                } else {
                    count += chong.getPizza();
                    ticket.setpTicket(ticket.getpTicket() - chong.getPizza());
                    chong.setPizza(0);
                }

            }

            if (ticket.getpTicket() >= 3) {
                int temp = ticket.getpTicket() / 3;
                ticket.sethTicket(ticket.gethTicket() + temp);
                ticket.setpTicket(ticket.getpTicket() % 3);

                if (chong.getHamburger() >= ticket.gethTicket()) {
                    count += ticket.gethTicket();
                    chong.setHamburger(chong.getHamburger() - ticket.gethTicket());
                    ticket.sethTicket(0);
                } else {
                    count += chong.getHamburger();
                    ticket.sethTicket(ticket.gethTicket() - chong.getHamburger());
                    chong.setHamburger(0);
                }

            }

            if (ticket.gethTicket() >= 3) {
                int temp = ticket.gethTicket() / 3;
                ticket.setcTicket(ticket.getcTicket() + temp);
                ticket.sethTicket(ticket.gethTicket() % 3);

                if (chong.getChicken() >= ticket.getcTicket()) {
                    count += ticket.getcTicket();
                    chong.setChicken(chong.getChicken() - ticket.getcTicket());
                    ticket.setcTicket(0);
                } else {
                    count += chong.getChicken();
                    ticket.setcTicket(ticket.getcTicket() - chong.getChicken());
                    chong.setChicken(0);
                }
            }
        }
        System.out.println(count);
    }
}
