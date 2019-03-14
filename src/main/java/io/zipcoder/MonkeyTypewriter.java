package io.zipcoder;

public class MonkeyTypewriter {
    public static void main(String[] args) {
        String introduction = "It was the best of times,\n" +
                "it was the blurst of times,\n" +
                "it was the age of wisdom,\n" +
                "it was the age of foolishness,\n" +
                "it was the epoch of belief,\n" +
                "it was the epoch of incredulity,\n" +
                "it was the season of Light,\n" +
                "it was the season of Darkness,\n" +
                "it was the spring of hope,\n" +
                "it was the winter of despair,\n" +
                "we had everything before us,\n" +
                "we had nothing before us,\n" +
                "we were all going direct to Heaven,\n" +
                "we were all going direct the other way--\n" +
                "in short, the period was so far like the present period, that some of\n" +
                "its noisiest authorities insisted on its being received, for good or for\n" +
                "evil, in the superlative degree of comparison only.";

        // Do all of the Monkey / Thread building here
        // For each Copier(one safe and one unsafe), create and start 5 monkeys copying the introduction to
        // A Tale Of Two Cities.
        Runnable copiers[] = new UnsafeCopier[5];

        for (int i = 0; i < copiers.length; i++) {
            copiers[i] = new UnsafeCopier(introduction);
        }

        for(Runnable runnable : copiers){
            Thread thread = new Thread(runnable);
            thread.start();
        }
        // This wait is here because main is still a thread and we want the main method to print the finished copies
        // after enough time has passed.
        try {
            Thread.sleep(5000);
        } catch(InterruptedException e) {
            System.out.println("MAIN INTERRUPTED");
        }

        //The jumbled output:

//        IIIIItttttwwwwwaaaaasssssttttthhhhheeeeebbbbbeeeeessssstttttoooooffffftttttiiiiimmmmmeeeeesssss,,,,,
//
//
//
//
//        iiiiitttttwwwwwaaaaasssssttttthhhhheeeeebbbbbllllluuuuurrrrrssssstttttoooooffffftttttiiiiimmmmmeeeeesssss,,,,,
//
//
//
//
//        iiiiitttttwwwwwaaaaasssssttttthhhhheeeeaaaaeggggaeeeegooooeffffowwwwfiiiiwssssiddddsoooodmmmmo,,,,m
//
//
//
//                ,iii
//        ittttiwwwwtaaaawasssssttttthhhheeeheaeaaaggggageeeeeooooofffffffffoooofooooolllloiiliisssishhshhnnhnneneeeessssssssss,,,,,
//
//
//
//        ii
//        iiitttttwwwwaaaawssssasttttthhhheeheeeeeeeepppppooooocccchhhchohooofoffffbbbbeebeelllleliiiieieeeffffe,,,,f
//
//
//                ,
//                ii
//        iittttitwwwwawaaassassttstththhheeeheeeeeepppepopooocccochhhhcoooohffoffiifiinnnincncccrrrrceereeddedduduuulllluiiilititttyyyyt,,,y,
//
//,
//
//        iiii
//        tittttwwwwawaaassssatsttthhhhteeeehsssseeeeseaeaaasssasooosonnnononoooffffoLLLfLiiiLiggggihhhghtttth,,,t,
//,
//
//
//        iii
//        ittitttwwwwaaawasassststtthhthhheeeeesssseeseeaaaaesasssooosonnnonoooonffffoDDDfDaaaaDrrrarkkkkrnnknneeenesessssssss,s,,,
//
//
//
//,iiii
//        itttttwwwwaaawassassstttthhthheeehesssesppppsprrrrriiiiinnnngnggggoooofffofhhhhfoooohpppopeeeep,e,,,
//,
//
//
//
//        iiiitttitwtwwwaawaassasstttsththhhheeeewwwewiiiiwnnnnittttneeeterrerroooorffoffddddfeeeedssssepppspapaaaiaiiiirrrrr,,,,,
//
//
//
//        ww
//        wwweeeehehhhaaaahddddadeeeevevvveeeevrrreryyryyttttythhhhhiiiininnngggngbgbbbeebeeffffeoooofrrrroereeeueuuususss,s,,,,
//
//
//
//
//        wwwwweeeeehhhhhaaaadadddndnnnonoootottththhhiihiinninnggngggbbbbeebeefefffoofoorrorreereeuueuusus,sss,
//,
//,,ww
//
//
//                ewwweewweeewwwereereerrreaeeealaalalllllgllgloggogiooioniinignngndggdgidddiriirireerrcceeettccctttttootttHoooHeHHHeeaeeavaavaevvevneene,nn,n
//,,
//,w
//
//                w
//        ewweweweewwewewrereeeerrraaeeellaaalllllggllologgioigoninoigngnigdndgdirgdiiedirrcirreteteecchcttcettttothththheeheeooeoottrtthhwhaheeeyerr-rr-wwww
//        aaaaiyyyyn----s----h
//
//
//                oi
//        iirninntsss,nhthhshoooheorrrprtttet,,,rt,ttihhthoeeehdppepwepeearrerisriioisooddoodwwdfwaawaassarsssslsoosiofffkoaaeafrrtrallhilriekilkpekietrektheteehtshepheerpenperptresrpeesseeesnernteintpnotepdtpre,peirteriodohirado,i,ttdotshd,hoa,atmttthsehsoaoaomfttme
//        essoiofootfm
//                sme
//        ientiooostffisn
//                s
//        oniiitteoiisssssitnnieaooesuiiststsatihiuaeoetsursthtitohatauuiorriettisthhtiooiierrnesisisititinisinsesitesisesistdinteonesdsndoiiiossnttnitsiteebstddbseooebinnineiinigttgnsrsrgebberceeceeieinicvgeinirevgveedred,ced,fec,fioefvroergiogovrdooeg,doodfdo,ooofdrrrofogfrooroforgrod
//        o
//                reooe
//        rdvveoifivrollifr,,lo
//                iien,rnvi
//        ttinehhlvete,ishsilueun,psptieuehrnprletelahsraeutlstipiveauetpvrdeeliedravetglegiradrveteeeeigedovrefeogedcfreeoceogmoefrpmoceapfoeracmoiropfsimaocspnooramniorpsnoiaolnrsynlooyi.nn.sloonyno.lnyl.y.
    }
}