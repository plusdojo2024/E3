
'use strict'
    let ouen=['もっと運動しよう！','もうひと頑張り！','よく頑張りました！','週末はゆっくり休もう'];
    function ouen_messagehyouji() {
        var random=Math.floor(Math.random()*4);
        console.log(random);
        const y=random;
          return y;
      }
      console.log(ouen_messagehyouji());
        //  const ouen_message1 = ouen[ouen_messagehyouji()];
			const ouen_message1 = ouen[ouen_messagehyouji()];
          document.getElementById('ouen_message').textContent= ouen_message1;