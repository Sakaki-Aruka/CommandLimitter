# CommandLimitter
Set limit to use commands.  
# config.yml  
## freePlayers  
Do not touch  
## limitCommands  
- all : full command  
  example)  all : /say hello  
  -  players cannot use only "/say hello".  
  
- pattern : pattern command  
  example)  pattern : /say   
  - players cannot use "/say".  

## blocks  
write blocks to unlock to use locked commands.  
should write in UPPERCASE.  

example) blocks: "DIAMOND_ORE,DEEPSLATE_DIAMOND_ORE"

## warnMessages  
write warning message to display to players who has yet unlock commands.  
you want to write multiple line messages, should use "!&!" between lines.  

example) warnMessages: "You cannot use this command.!&!You have to mine a Diamond ore."  

## unlockMessages  
write messages that send to player when unlocked.  

example) unlockMessages: "You unlock to use /say command.!&!Say hello to everyone!"  

# Commands  
## who can use  
only administrators  
## limitedit commands grammar  
/limitedit [a] [b] [c] [d]
### argument [a]  
can write "show" or "edit".  

### argument [b]  
if you write "show" in [a]  
- can write "players" or "blocks"  

if you write "edit" in [a]  
- can write "players"

### argument [c]  
if you write "show" in [a]  
- no arguments that you can write  

if you write "edit" in [a]  
- can write "add", "remove" or "clear".  
  - add : add a player who can use limited commands.  
  - remove : remove a player who can use limited commands from the list.  
  - clear : clear the list.(deprecation)    
  
### argument [d]  
if you write "show" in [a]  
- no arguments that you can write  

if you write "edit" in [a]  
- you can write a playername that operated by argument [c].  

if you write "clear" in [c]  
- should write "all" in argument [d].  

## commandlimitreload  

/commandlimitreload

can use only administrators.  
reload this plugins settings.  
(Settings are written to a config.yml)
