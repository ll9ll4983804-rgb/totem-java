Write a clean, complete Java client mod for Minecraft Fabric (version 26.2) focused exclusively on Sword PvP Assist, inside a single file named SwordAssistClient.java.

Requirements:
1. A dedicated KeyBinding to toggle Sword PvP Assist on and off.
2. Automatic hotbar switching to a sword in the following situations:
   - When landing on the ground after a mace attempt, gliding, or falling when the target was not hit or is on the ground.
   - When there is no effective mace hit opportunity and an opponent is close enough for sword combat.
3. Automatic sword attacks when a nearby player is within reach and the attack cooldown is ready so weak/spam hits are avoided.
4. Short randomized timing delays (for example between 35 and 80 milliseconds) to mimic human response intervals and avoid fixed robotic timing patterns on servers.
5. Clean, well-structured Fabric Client API code with clear comments for any parts that may need matching against Minecraft 26.2 mappings.
  
