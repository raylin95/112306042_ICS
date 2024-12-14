// 音效對應的鍵位
const keyMap = {
    w: "crash",
    a: "kick-bass",
    s: "snare",
    d: "tom-1",
    j: "tom-2",
    k: "tom-3",
    l: "tom-4",
  };
  
  // 點擊事件
  document.querySelectorAll(".drum").forEach(function (button) {
    button.addEventListener("click", function () {
      const soundName = this.getAttribute("data-sound"); // 獲取 data-sound 屬性
      playSound(soundName);
      buttonAnimation(soundName);
    });
  });
  
  // 鍵盤按下事件
  document.addEventListener("keydown", function (event) {
    const soundName = keyMap[event.key.toLowerCase()]; // 根據按下的鍵獲取對應的音效名稱
    if (soundName) {
      playSound(soundName);
      buttonAnimation(soundName);
    } else {
      console.log(`按下的按鍵 "${event.key}" 未綁定任何音效`);
    }
  });
  
  // 播放聲音
  function playSound(soundName) {
    const audio = new Audio(`sounds/${soundName}.mp3`); // 對應的音效路徑
    audio.play().catch((err) => {
      console.error(`無法播放音效 "${soundName}": ${err}`);
    });
  }
  
  // 按鈕動畫
  function buttonAnimation(soundName) {
    const activeButton = document.querySelector(`[data-sound="${soundName}"]`); // 找到對應的按鈕
    if (activeButton) {
      activeButton.classList.add("pressed"); // 添加動畫效果的類
      setTimeout(() => activeButton.classList.remove("pressed"), 100); // 100ms 後移除
    }
  }
  